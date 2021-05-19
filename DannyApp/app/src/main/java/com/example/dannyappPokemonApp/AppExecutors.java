package com.example.dannyappPokemonApp;
import android.os.Handler;
import android.os.Looper;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.LogRecord;

public class AppExecutors {
//main idea about this class is to post objects/things onto the main thread,
    //if there something executing on a backgrouund thread and you use this class going to post it on the main thread
    private static AppExecutors instance;

    public static AppExecutors getInstance() {
        if (instance == null) {
            instance = new AppExecutors();
        }
        return instance;

    }
    private final Executor ManagingData = Executors.newSingleThreadExecutor();
    private final Executor mainThreadExecutor= new MainThreadExecutor();
    //can schedule commands like runable tasks
    private final ScheduledExecutorService NetworkIO = Executors.newScheduledThreadPool(5);

    public ScheduledExecutorService networkIO() {
        return NetworkIO;
    }

    public Executor ManagingData() {
        return ManagingData;
    }
    public Executor mainThread() {
        return mainThreadExecutor;
    }
    private static class MainThreadExecutor implements Executor {
    private android.os.Handler mainThreadHandler= new Handler(Looper.getMainLooper());


      @Override
      public void execute(Runnable command) {
        mainThreadHandler.post(command);
      }
  }
  }

