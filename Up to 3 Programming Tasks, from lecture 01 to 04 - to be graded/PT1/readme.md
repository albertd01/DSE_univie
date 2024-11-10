How to build this project:
- Open Eclipse
- go to: File->open projects from file system , choose the PT1 directory and click finish
- run the Main class as a Java application

Question:
After finishing your implementation compare the generated output with the example output given at the top. Can you spot any differences? If yes, can you explain where those come from?

Yes, the order of the Hamming numbers is not necessarily ascending all the time. This happens due to the fact that in concurrent applications, the order of the execution of the different threads can depend on various factors such as the operating system etc.
