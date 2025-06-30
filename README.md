# Full Stack Spring Boot + React Project

## Project Structure

- `backend/` - Java Spring Boot API (Maven, H2 database)
- `frontend/` - React app (create-react-app)

## Prerequisites
- Node.js & npm
- Java 17+ (or as required by Spring Boot)
- Maven

## Running the Apps

### 1. Start the Backend
```sh
cd backend
./mvnw spring-boot:run
```
- The backend runs on [http://localhost:8080](http://localhost:8080)
- Test endpoint: [http://localhost:8080/api/hello](http://localhost:8080/api/hello)

### 2. Start the Frontend
```sh
cd frontend
npm start
```
- The frontend runs on [http://localhost:3000](http://localhost:3000)
- The React app proxies API requests to the backend via `/api/*` (see `package.json`)

## Customization
- Add more Spring Boot controllers for new API endpoints.
- Connect your React components to backend APIs as needed.

## Troubleshooting
- If you see CORS or proxy errors, ensure both servers are running and ports are correct.
- Restart the React dev server after changing the `proxy` in `package.json`.

---

Happy coding!
