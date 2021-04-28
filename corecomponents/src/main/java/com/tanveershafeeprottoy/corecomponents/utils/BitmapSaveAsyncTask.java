package com.tanveershafeeprottoy.corecomponents.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.io.File;
import java.lang.ref.WeakReference;

public class BitmapSaveAsyncTask extends AsyncTask<Void, Void, File> {
    private WeakReference<Context> weakReferenceContext;
    private Bitmap bitmap;
    private String directoryName;
    private String fileNameWithExtension;
    private int quality;
    private boolean append;
    private BitmapSaveAsyncTaskCallback bitmapSaveAsyncTaskCallback;

    public BitmapSaveAsyncTask(
        WeakReference<Context> weakReferenceContext,
        Bitmap bitmap,
        String directoryName,
        String fileNameWithExtension,
        int quality,
        boolean append,
        BitmapSaveAsyncTaskCallback bitmapSaveAsyncTaskCallback
    ) {
        this.weakReferenceContext = weakReferenceContext;
        this.bitmap = bitmap;
        this.directoryName = directoryName;
        this.fileNameWithExtension = fileNameWithExtension;
        this.quality = quality;
        this.append = append;
        this.bitmapSaveAsyncTaskCallback = bitmapSaveAsyncTaskCallback;
    }

    @Override
    protected File doInBackground(Void... params) {
        return FileUtils.save(
            weakReferenceContext.get(),
            bitmap,
            directoryName,
            fileNameWithExtension,
            quality,
            append
        );
    }

    @Override
    protected void onPostExecute(File file) {
        // super.onPostExecute(file);
        bitmapSaveAsyncTaskCallback.onCompleteBitmapSave(file);
    }

    public interface BitmapSaveAsyncTaskCallback {

        void onCompleteBitmapSave(File file);
    }
}
