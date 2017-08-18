@ECHO OFF
rem input rate=5fps, output rate=30fps
del output.mp4
type "pictures\*.png" | ffmpeg  -f image2pipe -r 5 -i pipe:.png -r 30 output.mp4
