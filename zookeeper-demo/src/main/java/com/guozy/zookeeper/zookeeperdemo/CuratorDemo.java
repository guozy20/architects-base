package com.guozy.zookeeper.zookeeperdemo;

import org.apache.curator.framework.AuthInfo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CuratorDemo {
    ZooKeeper zooKeeper = null;

    public static void main(String[] args) throws Exception {
        List<AuthInfo> authInfos = new ArrayList<>();
        AuthInfo authInfo = new AuthInfo("digest", "u2:u2".getBytes());
        // 需要获得多个权限只需要在此添加就可以，添加到list
        authInfos.add(authInfo);

        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().
                        connectString("192.168.124.12:2181,192.168.124.14:2181,192.168.128.12:2181").
                        sessionTimeoutMs(5000)
                        .retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                        connectionTimeoutMs(4000).authorization(authInfos).build();

        curatorFramework.start(); // 表示启动
//        create(curatorFramework);

//        update(curatorFramework);

//        operatorWithAsync(curatorFramework);
//        setAcl(curatorFramework);
//        get(curatorFramework);
//        addNodeCacheListener(curatorFramework, "/first_auth");
        addPathChildCacheListener(curatorFramework, "/first_auth");
        System.in.read();
    }

    private static String create(CuratorFramework curatorFramework) throws Exception {
        String rs = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .forPath("/first_111", "hello guozy".getBytes());

        return rs;

    }

    private static String update(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.setData().forPath("/first_111", "hello guozy1111".getBytes());

        return null;

    }

    // 异步访问||同步（future.get()）
    private static String operatorWithAsync(CuratorFramework curatorFramework) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        System.out.println(Thread.currentThread().getName() + ":" + event.getResultCode());
                        countDownLatch.countDown();
                    }
                })
                .forPath("/thrid", "second".getBytes());
        System.out.println("before");
        countDownLatch.await();
        System.out.println("after");
        return null;
    }

    private static String setAcl(CuratorFramework curatorFramework) throws Exception {

        List<ACL> acls = new ArrayList<>();
        // digest 类似于账号密码的授权
        ACL acl = new ACL(ZooDefs.Perms.CREATE | ZooDefs.Perms.DELETE, new Id("digest",
                DigestAuthenticationProvider.generateDigest("u1:u1")));

        ACL acl2 = new ACL(ZooDefs.Perms.ALL, new Id("digest",
                DigestAuthenticationProvider.generateDigest("u2:u2")));
        acls.add(acl);
        acls.add(acl2);

        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .withACL(acls).forPath("/first_auth", "123123".getBytes());

        return null;

    }

    private static String get(CuratorFramework curatorFramework) throws Exception {
        String rsl = new String(curatorFramework.getData().forPath("/first_auth"));
        System.out.println(rsl);
        return rsl;
    }

    /**
     * PathChild
     * Node
     * Tree
     */
    private static void addNodeCacheListener(CuratorFramework curatorFramework, String path) throws Exception {

        NodeCache nodeCache = new NodeCache(curatorFramework, path, false);
        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Receive Node Change");
                System.out.println("" + nodeCache.getCurrentData().getPath() + "->" + new String(
                        nodeCache.getCurrentData().getData()));
            }
        };
        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();
    }


    private static void addPathChildCacheListener(CuratorFramework curatorFramework, String path) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, path, true);
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework,
                                   PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("子节点事件变更的回调");
                ChildData childData = pathChildrenCacheEvent.getData();
                System.out.println(childData.getPath() + "->" + new String(childData.getData()));
            }
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }

    public void originApiTest() throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper("192.168.124.12:2181,192.168.124.14:2181,192.168.128.12:2181",
                5000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        // event 表示连接成功之后会产生的回调事件
                    }
                });
        Stat stat = new Stat();
       /* zooKeeper.getData("/first_auth", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 事件回调
            }
        }, stat);  // 针对当前节点*/

        zooKeeper.getData("/first_auth", new DataWatcherListener(), stat);  // 针对当前节点


       /* zooKeeper.exists();  // 针对当前节点
        zooKeeper.getChildren(); // 针对子节点的监听*/

    }

    class DataWatcherListener implements Watcher {

        @Override
        public void process(WatchedEvent event) {
            String path = event.getPath();
            // 再次注册监听
            try {
                zooKeeper.getData(path, this, new Stat());
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
