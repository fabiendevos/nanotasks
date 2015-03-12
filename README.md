# NanoTasks
NanoTasks is an extremely light way to execute code in the background on Android.
It is a wrapper arround AsyncTask that provides a simpler to use and more flexible API.

## Notes
 - NanoTasks is meant to be extremely simple to use and leightweight. If you are looking for more features please have a look to RxJava or Bolt.
 - The onSuccess/onError callbacks won't be called if your context is null. No more NPE crashes because the Activity was destroyed (Although as some people [pointed out](https://github.com/fabiendevos/nanotasks/issues/1]) this is not totally solved yet. I'm working on a better solution for the v2).

## Usage

```java
Tasks.executeInBackground(context, new BackgroundWork<Data>() {
    @Override
    public Data doInBackground() throws Exception {
        return fetchData(); // expensive operation
    }
}, new Completion<Data>() {
    @Override
    public void onSuccess(Context context, Data result) {
        display(result);
    }
    @Override
    public void onError(Context context, Exception e) {
        showError(e);
    }
});
```

## Dependency

**Gradle**
```groovy
compile 'com.fabiendevos:nanotasks:1.0.0'
```
**Maven**
```xml
<dependency>
  <groupId>com.fabiendevos</groupId>
  <artifactId>nanotasks</artifactId>
  <version>1.0.0</version>
</dependency>
```

You can also [download it directly from Maven Central repo](https://search.maven.org/#search%7Cga%7C1%7Cnanotasks).

## Author

Fabien Devos
 - [Twitter @fabien_devos](http://twitter.com/fabien_devos)
 - [LinkedIn](http://www.linkedin.com/in/fabiendevos)

## License

NanoTask is licensed under the Apache 2 license (you can use it in commercial and open source projects).

```
Copyright 2015 Fabien Devos

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
