# git代理设置方法解决：
    git config --global --unset http.proxy
    git config --global --unset https.proxy

    参考：
    https://blog.csdn.net/yihui8/article/details/108372441


<br>

Git提交报错："OpenSSL SSL_read: Connection was reset, errno 10054" 的解决方案：

    git config --global http.sslVerify "false"

    参考：https://blog.csdn.net/qq_29493173/article/details/114534057

# 查看git提交者：
    （1）项目设置：
    git config user.name "设置自己的名字"
    git config user.email "设置自己的邮箱"

    （2）全局设置：
    git config --global user.name "设置自己的名字"
    git config --global user.email "设置自己的邮箱"

    参考：
    https://blog.csdn.net/weixin_42257062/article/details/80509641
    https://blog.csdn.net/qq_46239275/article/details/118380606
    https://www.yiibai.com/git/git_config.html



