// 1.write a program that reading data from keyboard and writ e in to file
#include<stdio.h>

int main(int nargs,char* argv[])
	{
	if (nargs!=2)
		return 1;
	char *fname=argv[1],Buffer[100];
	int fd=creat(fname,0777),bytes;
	if (fd==-1)
		{
		printf("File %s not created successfully\n",argv[1]);
		return 1;
		}
	printf("File %s created successfully\n",argv[1]);
	while ( bytes=read(0,Buffer,sizeof(Buffer)) )//bytes is the no . of bytes read from input.. it will be zero if EOF occurs
		write(fd,Buffer,bytes);
	close(fd);
	return 0;
	}
//Ctrl + D EOF in UNIX/LINUX
//Ctrl + Z EOF in Windows
