package com.BeeFramework.Utils;

import android.os.Environment;

import com.BeeFramework.AppConst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {

	private static boolean isOutput = true;
	public static void output(String content) {
		if (isOutput) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH时mm分ss秒SSS");
			String time = sdf.format(new Date(System.currentTimeMillis()));
			System.out.println(content+"------>"+time);
		}
	}
	public static void writeToFile(String msg) {
		try {
			BufferedWriter bos = new BufferedWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + AppConst.LOG_DIR_PATH + "/" + "log.txt",true));
			bos.write(msg);
			bos.write("\n"+"-------------------------------------------------------"+"\n");
			bos.flush();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
