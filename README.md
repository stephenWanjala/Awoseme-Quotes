# Awoseme-Quotes

Retrofit
____________
For more information please see [the website][1].


Download
--------

Download [the latest JAR][2] or grab from Maven central at the coordinates `com.squareup.retrofit2:retrofit:2.9.0`.

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

Retrofit requires at minimum Java 8+ or Android API 21+.

Gson Converter
==============

A `Converter` which uses [Gson][1] for serialization to and from JSON.

A default `Gson` instance will be created or one can be configured and passed to the
`GsonConverterFactory` to further control the serialization.


Download
--------

Download [the latest JAR][2] or grab via [Maven][3]:
```xml
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>converter-gson</artifactId>
  <version>latest.version</version>
</dependency>
```
or [Gradle][3]:
```groovy
implementation 'com.squareup.retrofit2:converter-gson:latest.version'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].



[1]: https://github.com/google/gson
[2]: https://search.maven.org/remote_content?g=com.squareup.retrofit2&a=converter-gson&v=LATEST
[3]: http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.squareup.retrofit2%22%20a%3A%22converter-gson%22
[snap]: https://s01.oss.sonatype.org/content/repositories/snapshots/