package demos;

import org.springframework.cloud.stream.app.sftp.source.SftpSourceConfiguration;
import org.springframework.cloud.stream.app.log.sink.LogSinkConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.aggregate.AggregateApplicationBuilder;

@SpringBootApplication
public class  Sftp2S3Stream {

	public static void main(String[] args) {
		new AggregateApplicationBuilder(Sftp2S3Stream.class, args)
				.from(SftpSourceConfiguration.class).namespace("sftp").args("--mode=contents")
				.to(LogSinkConfiguration.class).namespace("log").args("--level=debug --name=omer").run(args);
	}
}
