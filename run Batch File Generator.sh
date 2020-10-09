set +v

if ! [ -x Batch_File_Generator.class ];
then
  javac Batch_File_Generator.java
fi

java Batch_File_Generator
echo
echo Closing in 3 seconds...
sleep 3
exit 0