# Sequence Monitoring Service for the GUS-OS Suite
The idea is to synchronize the task of generating sequence-numbers.<br>
At this state as a proof of concept the current state of this application only allows sequence-numbers for FormatFunc.

# Setup
Build the image and run!<br>
To start docker use:<br>
`docker run --rm -it -p 8080:8080 seq-service`

# Usage
Call the Entrypoint `/formatfunc/{formatname}`<br>
You'll get an unique sequence for the given formatname.
