# Loop file name with regex
# Rename file name with regex
# 势均力敌的我们_EP1
file_name="势均力敌的我们"
new_file_name="love_and_live"

for file in ./$file_name*.mp4 ; 
do 
    suffix=$(echo $file | grep -o -E "_EP[0-9]+.mp4")
    #echo $file
    #echo $new_file_name$suffix
    mv $file $new_file_name$suffix; 
done
