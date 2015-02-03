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
