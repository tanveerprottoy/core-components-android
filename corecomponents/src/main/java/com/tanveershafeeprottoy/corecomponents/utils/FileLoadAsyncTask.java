package com.tanveershafeeprottoy.corecomponents.utils;

import android.os.AsyncTask;

import java.io.File;

public class FileLoadAsyncTask extends AsyncTask<Void, Void, File> {
    private String path;
    private String name;
    private FileLoadAsyncTaskCallback fileLoadAsyncTaskCallback;

    public FileLoadAsyncTask(
        String path,
        String name,
        FileLoadAsyncTaskCallback fileLoadAsyncTaskCallback
    ) {
        this.path = path;
        this.name = name;
        this.fileLoadAsyncTaskCallback = fileLoadAsyncTaskCallback;
    }

    @Override
    protected File doInBackground(Void... params) {
        return FileUtils.loadFile(path, name);
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        fileLoadAsyncTaskCallback.onCompleteFileLoad(file);
    }

    public interface FileLoadAsyncTaskCallback {

        void onCompleteFileLoad(File file);
    }
}
