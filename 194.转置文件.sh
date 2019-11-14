# Read from the file file.txt and print its transposed content to stdout.
awk '{for (i=1;i<=NF;i++) data[i]=(NR==1?$i:data[i]" "$i)} END{for(i=1;i<=NF;i++) print data[i]}' file.txt