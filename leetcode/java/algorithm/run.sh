path=$1
javac "$path.java"
java -ea "$path.java"
rm "$path.class"
echo "Run Finish"