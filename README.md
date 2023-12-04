# patientservice

Simple patient hub service with provides a CRUD operation on patient.

# Patients Service

Patient Hub Service is a robust and scalable solution designed to streamline patient management and enhance healthcare services. This service empowers healthcare providers to efficiently manage patient data, appointments, and medical history, ensuring a seamless experience for both patients and healthcare professionals.

## Features

- **Patient Management:** Perform CRUD operation on patient and certain patient
resources such as easily add, update, and view patient records, including personal information.

Note:- Implemented caching for get put and delete operations along with profiling

## Installation

To install Patients Service, follow these steps:

1. **Clone the Repository:**
   ```
   git clone https://github.com/kiransaha/patientservice.git
   ```
2. **Run application:**
    ```
   go to directory "patientservice/patientsService/src/main/java/com/patient/project/"
    build and run application file named "PatientsServiceApplication.java"
   ```
4. **Run the Service:**
   ```
   using your favourite IDE such as Eclipse , import the project folder and run it as java application.
   ```
   
   The service will be accessible at `http://localhost:8080`.

## Usage

1. **API Endpoints:**
   - `GET /patients`: Get the list of all patients.
   - `GET /patients/id`: Get details of a specific patient by ID.
   - `POST /patients`: Add a new patient.
   - `PUT /patients/id`: Update patient details.
   - `DELETE /patients/:id`: Delete a patient record.

   (Add more endpoints as per your service functionality)

2. API HTTP method testing can be done using POSTMAN(preferred)
3. give Post request for patients as JSON (for eg :-
   {
        "id": 1,
        "name": "Ram",
        "age": 15,
        "gender": "Male"
    }

4. **Authentication:**
   - No authentication

5. **Sample Request:**
   ```http
   GET /patients/123
  
   ```

## Contributing

We welcome contributions from the community. If you find a bug or have an idea for a new feature, please open an issue or submit a pull request. Follow the [contribution guidelines](CONTRIBUTING.md) for more details.

## License

This project is licensed under the MY license, which means you are free to use, modify, and distribute the code as you like.

---

Thank you for using Patient Hub Service! If you have any questions or need further assistance, feel free to contact us or open an issue. Happy coding!
