package com.guozy.zookeeper.zookeeperdemo;

import org.apache.curator.framework.AuthInfo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CuratorDemo {
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
        get(curatorFramework);
    }


    private static String create(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .forPath("/first_111", "hello guozy".getBytes());

        return null;

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
                .withACL(acls).forPath("/first_auth","123123".getBytes());

        return null;

    }

    private static String get(CuratorFramework curatorFramework) throws Exception {
        String rsl = new String(curatorFramework.getData().forPath("/first_auth"));
        System.out.println(rsl);
        return rsl;
    }
}
