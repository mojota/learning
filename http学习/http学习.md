<h2 style="text-align:center">Http学习</h2>
### 1 简介
HTTP协议（HyperText Transfer Protocol，超文本传输协议）是因特网上应用最为广泛的一种网络传输协议，所有的WWW文件都必须遵守这个标准。

它是基于TCP/IP通信协议来传递数据的应用层协议。

万维网协会（World Wide Web Consortium）和互联网工程工作小组（Internet Engineering Task Force ）共同合作研究，最终发布了一系列的RFC文档。其中RFC 1945定义了HTTP/1.0版本，著名的RFC 2616定义了今天普遍使用的一个版本——HTTP 1.1。
### 2 发展
##### HTTP/0.9(1989-1991)  ----->  HTTP/1.0(1996)  ----->  HTTP/1.1(2000)  -----> HTTP/2.0(2015)
* HTTP/0.9

HTTP 0.9是第一个版本的HTTP协议。它的组成极其简单，请求(Request)只有一行:

` GET www.baidu.com `

> 只允许客户端发送GET这一种请求，且不支持请求头。由于没有HTTP头，造成了HTTP 0.9协议只支持一种内容，即纯文本。并且，如果得不到请求的信息，也没有404 500等错误码出现。

[HTTP 0.9协议文档](https://www.w3.org/Protocols/HTTP/AsImplemented.html)


* HTTP/1.0

HTTP协议的第二个版本，第一个在通讯中指定版本号的HTTP协议版本，至今仍被广泛采用。相对于HTTP 0.9 增加了如下主要特性:

> * 开始支持客户端通过POST方法向Web服务器提交数据，支持GET、HEAD、POST方法
> * HTTP 头:请求与响应都支持头域
> * HTTP 响应状态码：在响应的第一行，首先返回状态码和说明文本
> * 响应对象不只限于超文本
> * 允许保持连接，既一次TCP连接后，可以多次通信，不过默认还是传输一次数据后就关闭。

[HTTP/1.0协议文档](https://www.w3.org/Protocols/HTTP/1.0/spec.html)

* HTTP/1.1

随着互联网的迅速发展，人们对 HTTP 协议有了更高的要求。1999 年，现在最常见的 [RFC2616 - Hypertext Transfer Protocol HTTP/1.1](https://tools.ietf.org/html/rfc2616) 版本诞生了。从此之后，这个 HTTP 协议一直服务至今。并且，在后来的十多年里，这个协议还不断更新和细化，最终在 2014 年形成了 6 个 RFC：

> * [RFC 7230 - Hypertext Transfer Protocol (HTTP/1.1): Message Syntax and Routing 协议框架和连接管理](https://tools.ietf.org/html/rfc7230)
> * [RFC 7231 - Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content 动词、状态码和头定义](https://tools.ietf.org/html/rfc7231)
> * [RFC 7232 - Hypertext Transfer Protocol (HTTP/1.1): Conditional Requests 条件请求](https://tools.ietf.org/html/rfc7232)
> * [RFC 7233 - Hypertext Transfer Protocol (HTTP/1.1): Range Requests 断点续传相关](https://tools.ietf.org/html/rfc7233)
> * [RFC 7234 - Hypertext Transfer Protocol (HTTP/1.1): Caching 缓存相关](https://tools.ietf.org/html/rfc7234)
> * [RFC 7235 - Hypertext Transfer Protocol (HTTP/1.1): Authentication 认证相关](https://tools.ietf.org/html/rfc7235)

相比于HTTP/1.0，HTTP/1.1 增加了以下新特点：
> * 增加了Host头域
> * 新增了Request method: OPTIONS,PUT, DELETE, TRACE, CONNECT。
> * 缓存处理 HTTP/1.1在1.0的基础上加入了一些cache的新特性，引入了实体标签，一般被称为e-tags，新增更为强大的Cache-Control头。
> * 其中最大的特点是Persistent Connection(Keep-Alive保持连接) 被默认采用.
>> 保持连接特性，简单地说，当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的TCP连接不会关闭，如果客户端再次访问这个服务器上的网页，会继续使用这一条已经建立的连接。通过持久连接的机制，同一个 TCP 连接可以传输多次的 HTTP 请求、响应，他的使用率已经得到了一定的提高。
>> ![](keepalive.jpg)
>> ![](keepalive1.png)
> * 断点续传 客户端记录下当前的下载进度，并在需要续传时通知服务器本次需要下载的内容片断。HTTP1.1协议中定义了断点续传相关的属性，如Range和Content-Range。

### 3 工作原理
* HTTP协议工作于客户端-服务端架构为上。HTTP客户端通过URL向HTTP服务端即WEB服务器发送请求。Web服务器根据接收到的请求后，向客户端发送响应信息。
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


实例：
> ![](request_post.jpg)

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
* POST: 这个则可以在请求的实体内容中向服务器发送数据，传输没有数量限制，而且POST方法提交的数据放置在HTTP报文实体的主体里，所以POST方法的安全性比GET方法要高。

get请求实例：
>![](request_get.png)

 post请求实例：
> ![](request_post.jpg)

Get和Post最大的区别：就是Post有请求体 。而Get不存在这个内容。

#### 响应组成
HTTP响应也由四个部分组成：
* 状态行
* 响应头
* 空行
* 响应正文(本质就是一堆字节流)

> ![响应302](response1.png)
> ![响应200](response2.jpg)

#####  HTTP状态码

状态码分类：

HTTP状态码由三个十进制数字组成，第一个十进制数字定义了状态码的类型，后两个数字没有分类的作用。HTTP状态码共分为5种类型：

分类|分类描述
-|-
1** | 消息，服务器收到请求，需要请求者继续执行操作
2** | 成功，操作被成功接收并处理
3** | 重定向，需要进一步的操作以完成请求
4** | 客户端错误，请求包含语法错误或无法完成请求
5** | 服务器错误，服务器在处理请求的过程中发生了错误

常见的状态码有：
```
200 - OK：请求成功
301 - Moved Permanently：永久性转移
302 - Moved Temporarily：暂时性转移
404 - Not Found：请求失败，未找到资源
500 - Server Error：未知的服务器错误
```

[HTTP状态码](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status)


##### HTTP头

请求头:

Header | 解释 | 示例
-|-|-
Accept | 指定客户端能够接收的内容类型 | Accept: text/plain, text/html， \*/\*，text/*
Accept-Charset | 浏览器可以接受的字符编码集。 | Accept-Charset: iso-8859-5
Accept-Encoding | 指定浏览器可以支持的web服务器返回内容压缩编码类型。 | 	Accept-Encoding: compress, gzip
Accept-Language | 浏览器可接受的语言 | Accept-Language: en,zh
Accept-Ranges | 可以请求网页实体的一个或者多个子范围字段 | Accept-Ranges: bytes
Cache-Control | 指定请求和响应遵循的缓存机制 | Cache-Control: no-cache
Connection | 表示是否需要持久连接。（HTTP 1.1默认进行持久连接） | Connection: close
Cookie | HTTP请求发送时，会把保存在该请求域名下的所有cookie值一起发送给web服务器。 | Cookie: $Version=1; Skin=new;
Content-Length | 请求的内容长度 | Content-Length: 348
Content-Type | 请求的与实体对应的MIME信息 | Content-Type: application/x-www-form-urlencoded
Host | 指定请求的服务器的域名和端口号 | Host: www.baidu.com
Referer | 先前网页的地址，当前请求网页紧随其后,即来路 | Referer: http://blog.csdn.net/coder_pig
User-Agent | User-Agent的内容包含发出请求的用户信息 | User-Agent: Mozilla/5.0 (Linux; X11)
Range | 只请求实体的一部分，指定范围 | Range: bytes=500-999
If-Match | 只有请求内容与实体相匹配才有效 | If-Match: "737060cd8c284d8af7ad3082f209582d"
If-Modified-Since | 如果请求的部分在指定时间之后被修改则请求成功，未被修改则返回304代码 | If-Modified-Since: Sat, 29 Oct 2010 19:43:31 GMT
If-None-Match | 如果内容未改变返回304代码，参数为服务器先前发送的Etag，与服务器回应的Etag比较判断是否改变 | If-None-Match: "737060cd8c284d8af7ad3082f209582d"
If-Range | 如果实体未改变，服务器发送客户端丢失的部分，否则发送整个实体。参数也为Etag | If-Range: "737060cd8c284d8af7ad3082f209582d"
If-Unmodified-Since | 只在实体在指定时间之后未被修改才请求成功 | 	If-Unmodified-Since: Sat, 29 Oct 2010 19:43:31 GMT
Max-Forwards | 限制信息通过代理和网关传送的时间 | Max-Forwards: 10
Date | 请求发送的日期和时间 | Date: Tue, 15 Nov 2010 08:12:31 GMT
Authorization | HTTP授权的授权证书 | Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
Expect | 请求的特定的服务器行为 | Expect: 100-continue
From | 发出请求的用户的Email | From: user@email.com
Pragma | 用来包含实现特定的指令 | Pragma: no-cache
Proxy-Authorization | 连接到代理的授权证书 | Proxy-Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
TE | 客户端愿意接受的传输编码，并通知服务器接受接受尾加头信息 | TE: trailers,deflate;q=0.5
Upgrade | 向服务器指定某种传输协议以便服务器进行转换（如果支持） | Upgrade: HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11
Via | 通知中间网关或代理服务器地址，通信协议 | Via: 1.0 fred, 1.1 nowhere.com (Apache/1.1)
Warning | 关于消息实体的警告信息 | Warn: 199 Miscellaneous warning


响应头：

Header | 解释 | 示例
- | - | -
Accept-Ranges | 表明服务器是否支持指定范围请求及哪种类型的分段请求 | 	Accept-Ranges: bytes
Age | 从原始服务器到代理缓存形成的估算时间（以秒计，非负） | Age: 12
Allow | 对某网络资源的有效的请求行为，不允许则返回405 | Allow: GET, HEAD
Cache-Control | 告诉所有的缓存机制是否可以缓存及哪种类型 | Cache-Control: no-cache
Content-Encoding | web服务器支持的返回内容压缩编码类型 | Content-Encoding: gzip
Content-Language | 响应体的语言 | Content-Language: en,zh
Content-Length | 响应体的长度 | Content-Length: 348
Content-Location | 请求资源可替代的备用的另一地址 | Content-Location: /index.htm
Content-MD5 | 返回资源的MD5校验值 | Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==
Content-Range | 在整个返回体中本部分的字节位置 | Content-Range: bytes 21010-47021/47022
Content-Type | 返回内容的MIME类型 | Content-Type: application/x-www-form-urlencoded, Content-Type: text/html; charset=utf-8
Date | 原始服务器消息发出的时间 | Date: Thu, 01 Feb 2018 08:28:07 GMT
ETag | 请求变量的实体标签的当前值 | ETag: "737060cd8c284d8af7ad3082f209582d"
Expires | 响应过期的日期和时间(客户端应该在什么时候认为文档已经过期，从而不再缓存它)  | Expires: Thu, 01 Dec 2010 16:00:00 GMT
Last-Modified | 请求资源的最后修改时间，通常用于缓存 | Last-Modified: Tue, 15 Nov 2010 12:45:26 GMT
Location | 用来重定向接收方到非请求URL的位置来完成请求或标识新的资源 | 	Location: http://blog.csdn.net/coder_pig
Server | 服务器名字 | Server: nginx
Pragma | 包括实现特定的指令，它可应用到响应链上的任何接收方 | Pragma: no-cache
Proxy-Authenticate | 它指出认证方案和可应用到代理的该URL上的参数 | 	Proxy-Authenticate: Basic


HTTP头按照其不同的作用，可以分为四大类。
* 通用头(General header)
> 同时适用于请求和响应消息，但与最终消息主体中传输的数据无关的消息头。

* 实体头(Entity header)
> 包含有关实体主体(body)的更多信息，比如主体长(Content-Length)度或其MIME类型。既可以出现在HTTP POST方法的请求中，也可以出现在HTTP响应中。

* 请求头(HTTP Request Header)
> 请求头是由客户端发往服务端以便帮助服务端更好的满足客户端请求的头。请求头只能出现在HTTP请求中。

* 响应头(HTTP Response Header)
> HTTP响应头是那些描述HTTP响应本身的头，包含有关服务器响应的补充信息，如其位置或服务器本身（名称和版本等）的消息头。



#####  HTTP Content-Type
Content-Type(MIME type)，内容类型，用于定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件。

Type | 描述 | 示例
- | - | -
text | 各种纯文本类型 |	text/plain, text/html, text/css, text/javascript
image |	各种图片类型 |	image/gif, image/png, image/jpeg, image/bmp, image/webp
audio |	各种音频文件 |	audio/midi, audio/mpeg, audio/webm, audio/ogg, audio/wav
video |	各种视频文件 |	video/webm, video/ogg
application |	各种二进制数据 |	application/octet-stream, application/pkcs12, application/vnd.mspowerpoint, application/msword, application/xhtml+xml, application/xml,  application/pdf
multipart | | multipart/form-data, multipart/byteranges


常用的情况：
```
application/x-www-form-urlencoded   -------  请求体为键值对形式
application/json                    -------  请求体为json形式
text/plain                          -------  纯文本形式
application/octet-stream            -------  不知道下载文件类型时，使用二进制流
multipart/form-data                 -------  可发送复杂结构的表单，多用于文件上传
```

[HTTP content-type 对照表](http://www.runoob.com/http/http-content-type.html)

[MIME types](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types)

[MIME参考](http://www.w3school.com.cn/media/media_mimeref.asp)

### 5 Android发送接收Http请求
* HttpURLConnection 使用*** setRequestProperty(key,value) *** 方法来设置http头部。
* HttpURLConnection 通过getOutputStream输出流来设置请求体。
* HttpURLConnection 通过getResponseCode来获取响应状态码。
* HttpURLConnection 通过getInputStream()输入流来获取响应正文。

```
请求实例：

                try {
                    // 新建一个URL对象
                    URL newUrl = new URL(url);
                    // 打开一个HttpURLConnection连接
                    HttpURLConnection conn = (HttpURLConnection) newUrl.openConnection();
                    // 设置连接超时时间
                    conn.setConnectTimeout(10000);
                    //设置从主机读取数据超时
                    conn.setReadTimeout(10000);
                    // 设置请求方法,默认是GET
                    conn.setRequestMethod("POST");
                    // Post请求必须设置开启请求体 默认false
                    conn.setDoOutput(true);
                    // 配置是否保持连接,
                    conn.setRequestProperty("Connection", "keep-alive");
                    // 配置请求体的Content-Type
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; "
                            + "charset=UTF-8");
//                    conn.setRequestProperty("Content-type", "application/octet-stream;
// charset=UTF-8");

                    // 向服务器写请求数据(body)，如果是上传文件，则此处的请求体为具体文件的字节数组
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

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

```
[HurlStack.java](HurlStack.java)

### 6 上传
#### 文件流上传
通过设置 ` conn.setRequestProperty("Content-type","application/octet-stream;charset=UTF-8"); ` 并在body体中写入文件流。


#### multipart/form-data 上传
* multipart/form-data被用于从客户端发送html表单到服务端，它由不同的部分组成，由以--开始的分隔符分割，每个部分都有自己的HTTP headers包括Content-Disposition和用于文件上传的Content-Type。
* 使用post方式请求。

请求头（必须是这个）,其中的分割符，可以自己任意规定，但为了避免和正常文本重复，尽量要使用复杂一点的内容：
```
Content-Type: multipart/form-data; boundary=aBoundaryString
```

请求体，multipart/form-data的请求体也是一个字符串，不过和post的请求提不同的是它的构造方式，post是简单的name=value键值连接，而multipart/form-data是添加了分隔符等内容的构造体，如下：
```
--aBoundaryString
Content-Disposition: form-data; name="myFile"; filename="img.jpg"
Content-Type: image/jpeg

(data)
--aBoundaryString
Content-Disposition: form-data; name="myField"

(data)
--aBoundaryString
Content-Disposition: form-data; name="file3"; filename="binary"
Content-Type: application/octet-stream

(data)
--aBoundaryString--
```

比如要发送如下的表单：
```
<form action="http://localhost:8000/" method="post" enctype="multipart/form-data">
  <input type="text" name="myTextField">
  <input type="checkbox" name="myCheckBox">Check</input>
  <input type="file" name="myFile">
  <button>Send the file</button>
</form>
```
发送multipart/form-data类型的报文:
```
POST / HTTP/1.1
Host: localhost:8000
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=---------------------------8721656041911415653955004498
Content-Length: 465

-----------------------------8721656041911415653955004498
Content-Disposition: form-data; name="myTextField"

Test
-----------------------------8721656041911415653955004498
Content-Disposition: form-data; name="myCheckBox"

on
-----------------------------8721656041911415653955004498
Content-Disposition: form-data; name="myFile"; filename="test.txt"
Content-Type: text/plain

Simple file.
-----------------------------8721656041911415653955004498--
```

```
代码：

        String BOUNDARY = UUID.randomUUID().toString();  //边界标识,随机生成
        String LINE_END = "\r\n";
        String PREFIX = "--";
        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10 * 1000);
            conn.setConnectTimeout(10 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "utf-8");
            conn.setRequestProperty("Content-type", "multipart/form-data;boundary=" + BOUNDARY);

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

            StringBuffer sb = new StringBuffer();
            // 文本
            sb.append(PREFIX + BOUNDARY + LINE_END);
            sb.append("Content-Disposition: form-data; name=\"data\"" + LINE_END + LINE_END);
            sb.append("hello android!" + LINE_END); //内容

            // 文件
            sb.append(PREFIX + BOUNDARY + LINE_END);
            sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName
                    () + "\"" + LINE_END);
            sb.append("Content-Type: application/octet-stream; charset=utf-8" + LINE_END +
                    LINE_END);
            dos.write(sb.toString().getBytes());
            InputStream is = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                dos.write(bytes, 0, len);
            }
            is.close();
            dos.write(LINE_END.getBytes());
            // 结尾
            dos.write((PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes());
            dos.flush();
            int code = conn.getResponseCode();
            Log.e(TAG, "response code:" + code);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
```

[参考 ](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types)


### 7 断点续传
HTTP1.1协议（RFC2616）中定义了断点续传相关的内容，要实现断点续传的功能，通常都需要客户端记录下当前的下载位置，并在需要续传的时候通知服务端本次需要下载的内容片段。
主要用到 ** Range ** 和 ** Content-Range ** 实体头。

* 请求头中用Range指定字节的位置来告诉服务端本次需要续传的片段：

```
格式：Range:bytes=start-end

Range:bytes=200-                 表示200字节之后的范围
或
Range:bytes=-500                 表示最后500个字节：
或
Range:bytes=200-500              表示200-500之间的范围
或
Range:bytes=500-600,601-999      同时指定几个范围
或
Range:bytes=0-0,-1               第一个和最后一个字节
```
* 响应头Content-Range返回字节的范围:

```
格式：Content-Range:bytes start-end/size
Content-Range:bytes 200-1023/1024
```

* 响应头返回HTTP状态码为206
* ETag、Last-Modified等可用来校验续传时文件是否修改过，是否需要重头下载。


首次：

![首次请求](首次请求.png)


断点续传：

![断点续传](断点续传.png)

```
断点续传实例：

                FileOutputStream fos = null;
                InputStream in = null;
//                RandomAccessFile raf = null;
                try {
                    URL url = new URL(urlStr);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    conn.setUseCaches(false);
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Charset", "UTF-8");

                    if (mWriteCount > 0 && mWriteCount < mTotalLength) {
                        conn.setRequestProperty("Range", "bytes=" + mWriteCount + "-"); // 设置range头
                        Log.d(TAG, "Range:bytes=" + mWriteCount + "-");
                    }

                    int responseCode = conn.getResponseCode();
                    File file = new File(getFileFolder(), getFileName(urlStr));
                    if (responseCode == 200 || responseCode == 206) {
                        Log.d(TAG, conn.getHeaderFields().toString());
                        if (responseCode == 200) {
                            if (file.exists()) {
                                file.delete();
                            }
                            mTotalLength = conn.getContentLength();
                            mWriteCount = 0;
                        }
                        fos = new FileOutputStream(file, true); // true表示增量写文件
//                        raf= new RandomAccessFile(file,"rw"); //RandomAccessFile类功能丰富，支持跳到文件任意位置读写数据，故也可使用此类写入文件。
//                        raf.seek(mWriteCount);
                        int size = 1024;
                        in = conn.getInputStream();
                        byte[] buffer = new byte[size];
                        int count;
                        while ((count = in.read(buffer)) != -1) {
                            fos.write(buffer, 0, count);
//                            raf.write(buffer, 0 ,count);
                            mWriteCount = mWriteCount + count; // 记录已下载字节数
                            Log.d(TAG, "count:" + String.valueOf(count) + ",writeCount:"+ String.valueOf(mWriteCount));
                        }
                        if (mTotalLength == mWriteCount) {
                            Log.d(TAG, "下载完成");
                        }
                        Log.d(TAG, "writeCount:" + String.valueOf(mWriteCount));
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                    if (raf!= null) {
//                        try {
//                            raf.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }

```

--------------------------
<h4 style="text-align:right">by 王静</h4>
