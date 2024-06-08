path=$1
javac "$path.java"
java -ea "$path.java"
find ./src/ -type f -name "*.class" -exec rm -f {} \;
echo "Run Finish"