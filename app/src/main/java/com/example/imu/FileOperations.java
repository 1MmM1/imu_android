package com.example.imu;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;

public class FileOperations {

    public static void writetofile(Activity av, String fname) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String dir = av.getExternalFilesDir(null).toString();
                    File path = new File(dir);
                    if (!path.exists()) {
                        path.mkdirs();
                    }
//                    File file = new File(dir, fname+"-acc.txt");
//                    BufferedWriter outfile = new BufferedWriter(new FileWriter(file,false));
//                    for (int i = 0; i < Constants.accx.size(); i++) {
//                        outfile.append(Constants.accx.get(i)+","+Constants.accy.get(i)+","+Constants.accz.get(i));
//                        outfile.newLine();
//                    }
//                    outfile.flush();
//                    outfile.close();
//
//                    file = new File(dir, fname+"-grav.txt");
//                    outfile = new BufferedWriter(new FileWriter(file,false));
//                    for (int i = 0; i < Constants.gravx.size(); i++) {
//                        outfile.append(Constants.gravx.get(i)+","+Constants.gravy.get(i)+","+Constants.gravz.get(i));
//                        outfile.newLine();
//                    }
//                    outfile.flush();
//                    outfile.close();
                    File file = new File(dir, fname+"-mag.txt");
                    BufferedWriter outfile = new BufferedWriter(new FileWriter(file,false));
                    for (int i = 0; i < Constants.magx.size(); i++) {
                        outfile.append(Constants.magx.get(i)+","+Constants.magy.get(i)+","+Constants.magz.get(i));
                        outfile.newLine();
                    }
                    outfile.flush();
                    outfile.close();
                } catch(Exception e) {
                    Log.e("ex", "writeRecToDisk");
                    Log.e("ex", e.getMessage());
                }
            }
        }).run();
    }
}
