# NanoTasks
Extremely light way to execute code in the background on Android. Alternative to AsyncTask.

## Notes
 - NanoTasks is meant to be extremely simple to use and leightweight. If you are looking for more features please have a look to RxJava or Bolt.
 - The onSuccess/onError callbacks won't be called if your context is null. No more NPE crashes because the Activity was destroyed.

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

## Author

Fabien Devos
 - [Twitter @fabien_devos](twitter.com/fabien_devos)
 - [LinkedIn](www.linkedin.com/in/fabiendevos)

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
