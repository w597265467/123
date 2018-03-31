open(DATA, "<consumer-finance-7308.log") or die "file.txt 文件无法打开, $!";
while(<DATA>){
$_ =~s/(BqxdApi|Cy58Api|Session拦截器|".*?":".*?")/\e[1;31m$&\e[0m/g;$_ =~s/.*haier.*\n//g;
   print "$_";
}