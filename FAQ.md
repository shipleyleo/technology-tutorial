# 一、git代理设置方法解决
### 取消代理
  Git提交报错："Failed to connect to github.com port 443: Timed out" 的解决方案：

    git config --global --unset http.proxy
    git config --global --unset https.proxy

    参考：
    https://blog.csdn.net/yihui8/article/details/108372441

### 设置代理
  （1）Git提交报错："Failed to connect to github.com port 443: Timed out" 的解决方案：

  （2）Git提交报错："fatal: unable to access 'https://github.com/xxx/xxx.git/': The requested URL returned error: 500"

    git config --global http.proxy
    git config --global https.proxy

    参考：
    jianshu.com/p/41b525b3eeb1

### 解除SSL验证
  Git提交报错："OpenSSL SSL_read: Connection was reset, errno 10054" 的解决方案：

    git config --global http.sslVerify "false"

    参考：
    https://blog.csdn.net/qq_29493173/article/details/114534057

### 查看已有配置
Git提交报错："OpenSSL SSL_read: Connection was reset, errno 10054" 的解决方案：

    git config --global -l

    参考：
    https://blog.csdn.net/dta0502/article/details/90215089

<br>

# 二、查看git提交者：
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

<br>

# 三、如何解决Github网站打不开的问题
    
    # 1、查看github.com的IP地址
    网址：https://github.com.ipaddress.com
![查看github.com的IP地址](https://upload-images.jianshu.io/upload_images/15580222-0d23a0a098ab8c92.png?imageMogr2/auto-orient/strip|imageView2/2/w/542/format/webp)

    # 2、查看github.global.ssl.fastly.net的IP地址
    网址：https://fastly.net.ipaddress.com/github.global.ssl.fastly.net
![查看github.global.ssl.fastly.net的IP地址](https://upload-images.jianshu.io/upload_images/15580222-75116575bf8de80d.image?imageMogr2/auto-orient/strip|imageView2/2/w/819/format/webp)

    # 3、查找assets-cdn.github.com的IP地址
    进入网址https://github.com.ipaddress.com/assets-cdn.github.com
![查找assets-cdn.github.com的IP地址](https://upload-images.jianshu.io/upload_images/15580222-e614ce93f52534ac.png?imageMogr2/auto-orient/strip|imageView2/2/w/698/format/webp)
![查找assets-cdn.github.com的IP地址](https://upload-images.jianshu.io/upload_images/15580222-91699b10a54b0866.png?imageMogr2/auto-orient/strip|imageView2/2/w/515/format/webp)

    # 4、修改hosts文件
    hosts 文件位置（C:\Windows\System32\drivers\etc）及编辑方法：
    找到记事本--->右键以管理员方式打开

hosts文件：
```
#github.com
140.82.114.3 github.com
199.232.69.194 github.global.ssl.Fastly.net
185.199.108.153 assets-cdn.github.com
185.199.109.153 assets-cdn.github.com
185.199.110.153 assets-cdn.github.com
185.199.111.153 assets-cdn.github.com
```
备注：hosts中主要增加“github.com”这个。

其他原因与解决方案：有可能IP因多次推送失败后，被github纳入黑名单。解决方案是更改电脑ip地址。

参考：
[如何解决Github网站打不开的问题](https://www.jianshu.com/p/bf37776b4bb8)


