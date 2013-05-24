def file=new File(args[0]);

file.eachLine { 
	String[] deps=it.trim().split(":");
	def org=deps[0];
	def name=deps[1];
	def rev=deps[3];

	println "<dependency org=\"$org\" name=\"$name\" rev=\"$rev\" conf=\"runtime->default(*)\" />";
}
