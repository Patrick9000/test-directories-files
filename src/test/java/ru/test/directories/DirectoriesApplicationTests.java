package ru.test.directories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.test.directories.models.Entry;
import ru.test.directories.other.FileNameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectoriesApplicationTests {

	@Test
	public void testComparator()
	{
		//as in service method List<Entry> getFilesForDirectory(String dirId) divide list to 2:
		//one for directories,one for files.
		//file sizes a random
		List<Entry> files = new ArrayList<>();
		List<Entry> dirs = new ArrayList<>();

		files.add(new Entry("f.txt",false,4444));
		files.add(new Entry("f4_99.JPG",false,121212));
		files.add(new Entry("function.cpp",false,4524524));
		files.add(new Entry("F1.txt",false,75277));
		files.add(new Entry("f0008.doc",false,452787));
		files.add(new Entry("F4_00127.pdf",false,9998898));

		dirs.add(new Entry("X-FILES",true,0));
		dirs.add(new Entry("innerTemp",true,0));

		Collections.shuffle(files);
		Collections.shuffle(dirs);

		files.sort(new FileNameComparator());
		dirs.sort(new FileNameComparator());
		//as in service method add files to dirs;
		dirs.addAll(files);

		Assert.assertEquals("innerTemp",dirs.get(0).getName());
		Assert.assertEquals("X-FILES",dirs.get(1).getName());
		Assert.assertEquals("f.txt",dirs.get(2).getName());
		Assert.assertEquals("F1.txt",dirs.get(3).getName());
		Assert.assertEquals("f4_99.JPG",dirs.get(4).getName());
		Assert.assertEquals("F4_00127.pdf",dirs.get(5).getName());
		Assert.assertEquals("f0008.doc",dirs.get(6).getName());
		Assert.assertEquals("function.cpp",dirs.get(7).getName());

	}

}
