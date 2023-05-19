# Doctor App
This is a API project for `Patient`s to book appointment with `Doctor` for check up. Here I've used athentication for `Patient`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")

---
## Browser / Tools
![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")
---

## Model
- ### Patient
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long patientId;
      ```
    - ```java
      private String patientFirstName;
      ```
    - ```java
      private String patientLastName;
      ```
    - ```java
      private String patientEmail;
      ```
    - ```java
      private String patientPassword;
      ```
    - ```java
      private String patientContact;
      ```
    - ```java
      @OneToOne(mappedBy = "patient")
      private Appointment appointments;
      ```
- ### Doctor
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long doctorId;
      ```
    - ```java
      private String doctorName;
      ```
    - ```java
      @Enumerated(EnumType.STRING)
      private Specialization specialization;
      ```
    - ```java
      @OneToMany(mappedBy = "doctor")
      private List<Appointment> appointments;
      ```
- ### Appointment
    - ```java
      @Id
      @EmbeddedId
      private AppointmentKey id;
      ```
    - ```java
      @ManyToOne
      @JoinColumn(name = "fk_doctor_doc_id")
      private Doctor doctor;
      ```
    - ```java
      @OneToOne
      private Patient patient;
      ```
- ### Authentication Token
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long tokenId;
      ```
    - ```java
      private String token;
      ```
    - ```java
      private LocalDate tokenCreationDate;
      ```
    - ```java
      @OneToOne()
      @JoinColumn(nullable = false, name = "fk_patient_ID")
      private Patient patient;
      ```
- ### Appointment Key
    ```java
    @Embeddable
    public class AppointmentKey implements Serializable {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long appointmentId;
        public LocalDateTime time;
    }
    ```
- ### Specialization (Enum)
    - `ENT`
    - `ORTHO`
    - `GYNO`
    - `NEURO`
    - `DERMO`
---
## Dataflow
- ### End Points / Controllers
  - #### _Patient_
    `@RequestMapping("/patient")`
    - `@PostMapping("/signup")`
    - `@PostMapping("/signin")`
    - `@GetMapping("/doctors")`
  - #### _Doctor_
    `@RequestMapping("/doctor")`
    - `@PostMapping()`
- ### Services
  - #### _Patient_
    ```java
    public SignUpOutput signUp(SignUpInput signUpDto)
    ```
    ```java
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException
    ```
    ```java
    public SignInOutput signIn(SignInInput signInDto)
    ```
    ```java
    public List<Doctor> getAllDoctors()
    ```
    ```java
    public void cancelAppointment(AppointmentKey key)
    ```
  - #### _Doctor_
    ```java
    public void addDoc(Doctor doc)
    ```
    ```java
    public List<Doctor> getAllDoctors()
    ```
    ```java
    public List<Appointment> getMyAppointments(Long docId)
    ```
  - #### _Auth_
    ```java
    void saveToken(AuthenticationToken token);
    ```
    ```java
    AuthenticationToken getToken(Patient patient);
    ```
    ```java
    boolean authenticate(String userEmail, String token);
    ```
  - #### _Appointment_
    ```java
    public void bookAppointment(Appointment appointment)
    ```
    ```java
    public void cancelAppointment(AppointmentKey key)
    ```
  - #### _Authentication_
    ```java
    public void saveToken(AuthenticationToken token)
    ```
    ```java
    public AuthenticationToken getToken(Patient patient)
    ```
    ```java
    public boolean authenticate(String userEmail, String token)
    ```
- ### Repository
    - _Patient_
        ```java
        public interface IPatientRepo extends JpaRepository<Patient, Long> {

          Patient findFirstByPatientEmail(String userEmail);
        }
        ```
    - _Doctor_
        ```java
        public interface IDoctorRepo extends JpaRepository<Doctor, Long> {


          Doctor findByDoctorId(Long docId);
        }
        ```
    - _Appointment_
        ```java
        public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

          public String findByIdAppId(Long id);
        }
        ```
    - _AuthenticationToken_
        ```java
        public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {


          AuthenticationToken findByPatient(Patient patient);

          AuthenticationToken findFirstByToken(String token);
        }
        ```
- ### Database
    I have used `MySQL` database in this project. And used `SpringDataJPA`.
---
## Datastructures
- `ArrayList<>`
---
## Summary
This API is a `Spring Boot` project that is about Patients making appointments with Doctors. In this project request is sent from the client on HTTP in JSON body or from path variable and stored in object then response is sent back from the server by JSON format to the client.

