# NanoTasks
Extremely light way to execute code in the background on Android. Alternative to AsyncTask.

## Usage

```java
    Tasks.executeInBackground(context, new BackgroundWork<Data>() {
        @Override
        public String doInBackground() throws Exception {
            return fetchData(); // expensive operation
        }
    }, new Completion<String>() {
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
