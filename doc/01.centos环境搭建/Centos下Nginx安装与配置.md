# Centos下Nginx安装与配置

Nginx是一款轻量级的网页服务器、反向代理服务器。相较于Apache、lighttpd具有占有内存少，稳定性高等优势。**它最常的用途是提供反向代理服务。**

## 1.安装

在Centos下，yum源不提供nginx的安装，可以通过切换yum源的方法获取安装。也可以通过直接下载安装包的方法，**以下命令均需root权限执行**：

首先安装必要的库（nginx 中gzip模块需要 zlib 库，rewrite模块需要 pcre 库，ssl 功能需要openssl库）。选定**/usr/local**为安装目录，以下具体版本号根据实际改变。

首先由于nginx的一些模块依赖一些lib库，所以在安装nginx之前，必须先安装这些lib库，这些依赖库主要有g++、gcc、openssl-devel、pcre-devel和zlib-devel 所以执行如下命令安装

```bash
$   yum install gcc-c++ 
$   yum install pcre pcre-devel 
$   yum install zlib zlib-devel 
$   yum install openssl openssl--devel  
```

安装之前，最好检查一下是否已经安装有nginx

```bash
$   find -name nginx  
```

如果系统已经安装了nginx，那么就先卸载

```bash
$   yum remove nginx 
```

首先进入/usr/local目录

```bash
$   cd /usr/local
```

从官网下载最新版的nginx

```bash
$   wget http://nginx.org/download/nginx-1.7.4.tar.gz
```

解压nginx压缩包

```bash
$   tar -zxvf nginx-1.7.4.tar.gz
```

会产生一个nginx-1.7.4 目录，这时进入nginx-1.7.4目录

```bash
 $   cd  nginx-1.7.4
```

接下来安装，使用--prefix参数指定nginx安装的目录,make、make install安装

```bash
 $   ./configure  $默认安装在/usr/local/nginx  
 $   make 
 $   make install      
```

如果没有报错，顺利完成后，最好看一下nginx的安装目录

```bash
$   whereis nginx 
```

安装完毕后，进入安装后目录（/usr/local/nginx）便可以启动或停止它了。

到此，使用CentOS安装nginx已经完成了。

## 2.启动

```bash
$ /usr/local/nginx/sbin/nginx
```

检查是否启动成功：

打开浏览器访问此机器的 IP，如果浏览器出现 Welcome to nginx! 则表示 Nginx 已经安装并运行成功。

如果运行的时候不带-c参数，那就采用默认的配置文件，即/etc/nginx/nginx.conf

**查看运行进程状态：**

```bash
ps aux | grep nginx
```

打开浏览器,访问http://localhost/看看nginx的默认页面

分命令如下：

重启：

```bash
$ /usr/local/nginx/sbin/nginx –s reload
```

停止：

```bash
$ /usr/local/nginx/sbin/nginx –s stop
```

测试配置文件是否正常：

```bash
$ /usr/local/nginx/sbin/nginx –t
```

强制关闭：

```bash
$ pkill nginx
```

## 3.配置nginx反向代理

```bash
worker_processes  1;
events {
    worker_connections  1024;
}
http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;
    #！！！！ 配置代理server组，标识为myboot
    upstream myboot {
       server  127.0.0.1:8081 weight=10;
       server  127.0.0.1:8080 weight=10;
     }                   
    server {
        listen       80;
        server_name  localhost;
        location / {
            root   html;
            index  index.html index.htm;
        }
	#！！！！配置代理路径
	location /myboot {
		proxy_pass http://myboot/;
	}
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
}
```

