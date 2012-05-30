import re

desc = "My name is Igor. igor is a good tennis player."
p = re.compile('igor', re.I)
print(p.findall(desc))
desc = "My name is Igor\n hi igor\n this is it igoR that"
p = re.compile('igor$', re.I)

#detecting doubled words
p = re.compile(r'(\w+)\s+\1')
desc = "Paris in the the spring spring"
print(p.findall(desc))

p = re.compile("([abc])+")
m = re.match(p, "abc")
print(m.groups())
print(p.findall("abc"))

desc = "file1.bat file2.txt file3.igor file4.bat file5.exe"
p = re.compile(r'.+?[.](?!bat|exe).+?\s+')
print(p.findall(desc))

#splitting
p = re.compile("\W+")
desc = 'This is a test, short and sweet, of split().'
print(p.split(desc))