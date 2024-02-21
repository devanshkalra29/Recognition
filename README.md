**Overview**
The project provides a web service that interacts with AWS Rekognition and S3 services, enabling functionalities such as image recognition and file storage. It is structured around Spring Boot, utilizing REST controllers for handling web requests.

**Key Components**
Rekognition Service: Implements functionality to detect labels in an image using AWS Rekognition. It takes an image file name as input, processes it, and returns the detected labels. View RekognitionController

S3 Bucket Service: Manages file uploads to an AWS S3 bucket. It provides an endpoint to upload a file, which is then stored in the specified S3 bucket. View S3Controller

**Configuration**
The application's configuration, including AWS credentials and the S3 bucket name, is managed through the application.yml file, ensuring that sensitive information is kept secure and configurable.

**Usage**
To use the services provided by this application, users can send HTTP POST requests to the /labels endpoint for detecting image labels and to the /upload endpoint for uploading files to S3.

**Conclusion**
This project leverages the power of AWS cloud services to provide a simple yet effective solution for image recognition and file storage, demonstrating the integration of AWS services within a Spring Boot application.
