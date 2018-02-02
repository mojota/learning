<h2 style="text-align:center">Http学习</h2>
### 1 简介
HTTP协议（HyperText Transfer Protocol，超文本传输协议）是因特网上应用最为广泛的一种网络传输协议，所有的WWW文件都必须遵守这个标准。

它是一个基于TCP/IP通信协议来传递数据的应用层协议。

万维网协会（World Wide Web Consortium）和互联网工程工作小组（Internet Engineering Task Force ）共同合作研究，最终发布了一系列的RFC文档。其中RFC 1945定义了HTTP/1.0版本，著名的RFC 2616定义了今天普遍使用的一个版本——HTTP 1.1。
### 2 发展
##### HTTP/0.9(1989-1991)  ----->  HTTP/1.0(1996)  ----->  HTTP/1.1(2000)  -----> HTTP/2.0(2015)
* HTTP/0.9

> HTTP 0.9是第一个版本的HTTP协议。它的组成极其简单，请求(Request)只有一行:

> ` GET www.baidu.com `

> 只允许客户端发送GET这一种请求，且不支持请求头。由于没有HTTP头，造成了HTTP 0.9协议只支持一种内容，即纯文本。并且，如果得不到请求的信息，也没有404 500等错误码出现。

> [HTTP 0.9协议文档](https://www.w3.org/Protocols/HTTP/AsImplemented.html)


* HTTP/1.0

> HTTP协议的第二个版本，第一个在通讯中指定版本号的HTTP协议版本，至今仍被广泛采用。相对于HTTP 0.9 增加了如下主要特性:

> * 开始支持客户端通过POST方法向Web服务器提交数据，支持GET、HEAD、POST方法
* HTTP 头:请求与响应都支持头域
* HTTP 响应状态码：在响应的第一行，首先返回状态码和说明文本
* 响应对象不只限于超文本
* 允许保持连接，既一次TCP连接后，可以多次通信，不过默认还是传输一次数据后就关闭。

[HTTP/1.0协议文档](https://www.w3.org/Protocols/HTTP/1.0/spec.html)

* HTTP/1.1

> 随着互联网的迅速发展，人们对 HTTP 协议有了更高的要求。1999 年，现在最常见的 [RFC2616 - Hypertext Transfer Protocol HTTP/1.1](https://tools.ietf.org/html/rfc2616) 版本诞生了。从此之后，这个 HTTP 协议一直服务至今。并且，在后来的十多年里，这个协议还不断更新和细化，最终在 2014 年形成了 6 个 RFC：

> * [RFC 7230 - Hypertext Transfer Protocol (HTTP/1.1): Message Syntax and Routing 协议框架和连接管理](https://tools.ietf.org/html/rfc7230)
* [RFC 7231 - Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content 动词、状态码和头定义](https://tools.ietf.org/html/rfc7231)
* [RFC 7232 - Hypertext Transfer Protocol (HTTP/1.1): Conditional Requests 条件请求](https://tools.ietf.org/html/rfc7232)
* [RFC 7233 - Hypertext Transfer Protocol (HTTP/1.1): Range Requests 断点续传相关](https://tools.ietf.org/html/rfc7233)
* [RFC 7234 - Hypertext Transfer Protocol (HTTP/1.1): Caching 缓存相关](https://tools.ietf.org/html/rfc7234)
* [RFC 7235 - Hypertext Transfer Protocol (HTTP/1.1): Authentication 认证相关](https://tools.ietf.org/html/rfc7235)

> 相比于HTTP/1.0，HTTP/1.1 增加了以下新特点：
* 增加了Host头域
* 新增了Request method: OPTIONS,PUT, DELETE, TRACE, CONNECT。
* 缓存处理
> HTTP/1.1在1.0的基础上加入了一些cache的新特性，引入了实体标签，一般被称为e-tags，新增更为强大的Cache-Control头。
* 最大的特点是 ** Persistent Connection(Keep-Alive保持连接) ** 被默认采用.
>> 保持连接特性，简单地说，当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的TCP连接不会关闭，如果客户端再次访问这个服务器上的网页，会继续使用这一条已经建立的连接。通过持久连接的机制，同一个 TCP 连接可以传输多次的 HTTP 请求、响应，他的使用率已经得到了一定的提高。
>> ![](keepalive.jpg)
>> ![](keepalive1.png)

### 3 工作原理
* HTTP协议工作于客户端-服务端架构为上。HTTP客户端通过URL向HTTP服务端即WEB服务器发送请求。
* Web服务器根据接收到的请求后，向客户端发送响应信息。
* HTTP底层通过TCP/IP建立连接，默认端口是TCP的80端口，也可自行更改。

### 4 HTTP/1.1 消息结构
HTTP由两部分组成：请求和响应。

#### 请求组成
一个HTTP请求由四个部分组成:
* 请求行（request line）
* 请求头部（header）
* 空行
* 请求数据(可选)

> ![](request1.png)

> ![](request2.jpg)

##### 请求方法

序号|方法|描述
 - | :- | :-
1|GET|请求指定的页面信息，并返回实体主体。
2|HEAD|类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
3|POST|向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。
4|PUT|从客户端向服务器传送的数据取代指定的文档的内容。
5|DELETE|请求服务器删除指定的页面。
6|CONNECT|HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器。
7|OPTIONS|允许客户端查看服务器的性能。
8|TRACE|回显服务器收到的请求，主要用于测试或诊断。


常用的：
* GET : 在请求的URL地址后以?的形式带上交给服务器的数据，多个数据之间以&进行分隔， 但数据容量通常不能超过2K，比如:http://xxx?username=xxx&pwd=xxx 。
* POST: 这个则可以在请求的实体内容中向服务器发送数据，传输没有数量限制。

get请求实例：
>![](request_get.png)

 post请求实例：
> ![](request2.jpg)

Get和Post最大的区别：就是Post有** 请求体 ** 。而Get不存在这个内容。

#### 响应组成
HTTP响应也由四个部分组成：
* 状态行
* 响应头
* 空行
* 响应正文

> ![响应302](response1.png)
> ![响应200](response2.jpg)

#####  HTTP状态码

状态码分类：

HTTP状态码由三个十进制数字组成，第一个十进制数字定义了状态码的类型，后两个数字没有分类的作用。HTTP状态码共分为5种类型：

分类|分类描述
-|-
1** | 消息，服务器收到请求，需要请求者继续执行操作,
2** | 成功，操作被成功接收并处理
3** | 重定向，需要进一步的操作以完成请求
4** | 客户端错误，请求包含语法错误或无法完成请求
5** | 服务器错误，服务器在处理请求的过程中发生了错误

常见的状态码有：
```
200 - 请求成功
302 - 要求客户端执行临时重定向
404 - 请求的资源（网页等）不存在
500 - 内部服务器错误
```

[HTTP状态码](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status)


##### HTTP头
HTTP头按照其不同的作用，可以分为四大类。
* 通用头(General header)
> 同时适用于请求和响应消息，但与最终消息主体中传输的数据无关的消息头。

Header | 解释	| 示例
- | - | -
Cache-Control | 指定请求和响应遵循的缓存机制 | Cache-Control: no-cache
Connection | 表示是否需要持久连接。（HTTP 1.1默认进行持久连接） | 	Connection: keep-alive
Date | 原始服务器消息发出的时间 | Date: Thu, 01 Feb 2018 08:28:07 GMT


* 实体头(Entity header)
> 包含有关实体主体的更多信息，比如主体长(Content-Length)度或其MIME类型。既可以出现在HTTP POST方法的请求中，也可以出现在HTTP响应中。

Header | 解释	| 示例
- | - | -
Content-Length | 内容长度 | Content-Length: 348
Content-Type | 内容是属于什么MIME类型 | Content-Type: application/x-www-form-urlencoded, Content-Type: text/html; charset=utf-8
Content-Encoding | web服务器支持的返回内容压缩编码类型 | 	Content-Encoding: gzip
Content-Language | 响应体的语言 | Content-Language: en,zh
Content-MD5 | 返回资源的MD5校验值 | Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==
Expires | 响应过期的日期和时间(客户端应该在什么时候认为文档已经过期，从而不再缓存它) | Expires: Thu, 01 Dec 2010 16:00:00 GMT
Last-Modified | 请求资源的最后修改时间 | Last-Modified: Tue, 15 Nov 2010 12:45:26 GMT

* 请求头(HTTP Request Header)
> 请求头是由客户端发往服务端以便帮助服务端更好的满足客户端请求的头。请求头只能出现在HTTP请求中。

Header | 解释	| 示例
- | - | -
Accept | 指定客户端能够接收的内容类型 | Accept: text/plain, text/html， \*/\*，text/*
Accept-Charset | 浏览器可以接受的字符编码集。| Accept-Charset: iso-8859-5
Accept-Encoding | 指定浏览器可以支持的web服务器返回内容压缩编码类型。 | Accept-Encoding: compress, gzip
Accept-Language | 浏览器可接受的语言 | Accept-Language: en,zh
Cookie | HTTP请求发送时，会把保存在该请求域名下的所有cookie值一起发送给web服务器 | Cookie: $Version=1; Skin=new;
Host | 指定请求的服务器的域名和端口号 | Host: www.baidu.com
Referer | 先前网页的地址，当前请求网页紧随其后,即来路 | Referer: http://blog.csdn.net/coder_pig
Authorization | HTTP授权的授权证书 | Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
User-Agent | User-Agent的内容包含发出请求的用户信息 | 	User-Agent: Mozilla/5.0 (Linux; X11)

* 响应头(HTTP Response Header)
> HTTP响应头是那些描述HTTP响应本身的头，包含有关服务器响应的补充信息，如其位置或服务器本身（名称和版本等）的消息头。

Header | 解释 | 示例
- | - | -
Location | 用来重定向的url地址(例如：302) | Location: http://blog.csdn.net/coder_pig
Server | 服务器名字 | Server: nginx



[HTTP header 参考](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers)

#####  HTTP Content-Type
Content-Type(MIME type)，内容类型，用于定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件。

Type | 描述 | 示例
- | -
text | 各种纯文本类型 |	text/plain, text/html, text/css, text/javascript
image |	各种图片类型 |	image/gif, image/png, image/jpeg, image/bmp, image/webp
audio |	各种音频文件 |	audio/midi, audio/mpeg, audio/webm, audio/ogg, audio/wav
video |	各种视频文件 |	video/webm, video/ogg
application |	各种二进制数据 |	application/octet-stream, application/pkcs12, application/vnd.mspowerpoint, application/msword, application/xhtml+xml, application/xml,  application/pdf
multipart | | multipart/form-data, multipart/byteranges


常用的情况：
```
text/plain                 -------    文本类型
application/octet-stream   -------    不知道下载文件类型时，使用二进制流
```

[HTTP content-type 对照表](http://www.runoob.com/http/http-content-type.html)

[MIME types](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types)

### 5 Android发送接收Http请求
* HttpURLConnection 使用*** setRequestProperty(key,value) *** 方法来设置http头部。
* HttpURLConnection 通过getOutputStream输出流来设置请求体。
* HttpURLConnection 通过getResponseCode来获取响应状态码。
* HttpURLConnection 通过getInputStream()输入流来获取响应正文。

```
// 新建一个URL对象
URL newUrl = new URL(url);
// 打开一个HttpURLConnection连接
HttpURLConnection conn = (HttpURLConnection)newUrl.openConnection();
// 设置连接超时时间
conn.setConnectTimeout(10000);
//设置从主机读取数据超时
conn.setReadTimeout(10000);
// 设置请求方法
conn.setRequestMethod("POST");
// Post请求必须设置允许输出 默认false
conn.setDoOutput(true);
// 配置是否保持连接,
conn.setRequestProperty("Connection", "keep-alive");
// 配置请求体的Content-Type
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


// 向服务器写数据
String data = "username=135700&accountType=1";
OutputStream out = conn.getOutputStream();
out.write(data.getBytes());
out.flush();
out.close();

// 判断请求是否成功
if (conn.getResponseCode() == 200) {
    // 获取返回的数据
    String result = streamToString(conn.getInputStream());
    Log.e(TAG, "请求成功，result:" + result);
} else {
    Log.e(TAG, "请求失败" + conn.getResponseCode());
}
// 关闭连接
conn.disconnect();

```

[HurlStack.java](HurlStack.java)

### 6 断点续传
