use 5.010;
use strict;
use warnings;

my $filename = 'result.txt';
open(FH, '<', $filename) or die $!;
my $filename2 = 'primeResult.txt';
open(DES, '>', $filename2) or die $!;

while(<FH>){
   print $_;
   if (index($_, "not") == -1) {
	my $index = index($_, ' ');
    	my $number = substr($_,0,$index);
	print DES "$number \n";
   }
}

close(FH);
close(des);