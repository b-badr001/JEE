package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HDFSReadApp {
    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/file/file1");
        FSDataInputStream fsi = fs.open(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fsi));
        String line = null;
        while ((line = br.readLine())!=null) {
            System.out.printf(line);
        }
        br.close();

    }
}