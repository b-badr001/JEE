package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HDFSWriteApp {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream fss = fs.create(new Path("/bddcFile.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fss));
        bw.write("Bonjour hdfs hdfs");
        bw.newLine();
        bw.write("Bye");
        bw.close();
    }
}
