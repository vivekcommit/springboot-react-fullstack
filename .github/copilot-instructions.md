
# Copilot Instructions for This Project

## Architecture Overview
- Full-stack app: Spring Boot backend (`backend/`), React frontend (`frontend/`).
- Backend: Java 17+, Maven, JPA, H2 (local tests), PostgreSQL (dev/CI), log4j2 logging, REST API.
- Frontend: create-react-app, centralized logger, ErrorBoundary for error handling, API calls proxied via `/api/*`.

## Key Directories & Files
- Backend source: `backend/src/main/java/com/example/backend/`
- Backend config: `backend/src/main/resources/` (`application.properties`, `log4j2.xml`)
- Frontend source: `frontend/src/`
- CI/CD: `.github/workflows/ci.yml` (runs backend+frontend tests, sets up PostgreSQL)
- Instructions: `README.md` (root), `.github/copilot-instructions.md` (this file)

## Developer Workflows
- **Build/Run Backend:**
	- `cd backend; ./mvnw spring-boot:run` (port 8080)
- **Test Backend:**
	- `cd backend; ./mvnw test` (uses H2 by default, PostgreSQL for CI)
	- Test profiles: `src/test/resources/application.properties` (local), `application-github.properties` (CI)
- **Run Frontend:**
	- `cd frontend; npm start` (port 3000, proxies `/api/*` to backend)
- **Test Frontend:**
	- `cd frontend; npm test -- --watchAll=false`
- **CI/CD:**
	- See `.github/workflows/ci.yml` for build/test steps and service setup

## Project-Specific Patterns & Conventions
- **Backend Logging:**
	- All controllers/services use log4j2 (`logger.debug/info/error`) with workflow markers
	- Exception handling via `GlobalExceptionHandler`
- **Frontend Logging & Error Handling:**
	- Use the `logger` utility and `ErrorBoundary` in `src/App.js` for all API/UI errors
- **API Design:**
	- REST endpoints under `/api/` (e.g., `/api/hello`, `/api/cast`, `/api/messages`)
	- Data flow: React fetches from backend, backend uses JPA repositories
- **CORS/Proxy:**
	- Backend CORS configured for `http://localhost:3000` in `BackendApplication.java`
	- Frontend proxies API calls via `frontend/package.json` `proxy` field
- **Database:**
	- H2 for local tests, PostgreSQL for dev/CI (see `application.properties`)
- **Testing:**
	- Backend: JUnit, MockMvc for controller tests
	- Frontend: React Testing Library

## Integration Points
- **Backend ↔ Frontend:**
	- React fetches data from backend REST endpoints using relative `/api/*` URLs
- **CI/CD:**
	- GitHub Actions workflow sets up PostgreSQL, runs backend/frontend tests

## Examples
- Add REST endpoint: create controller in `backend/src/main/java/com/example/backend/`, update repository/entity as needed
- Fetch data in React: `fetch('/api/cast')` in `frontend/src/App.js`
- Add logging: use log4j2 in backend, `logger` in frontend

## Troubleshooting
- If frontend can't reach backend, check CORS config and proxy setup
- Restart servers after config changes
- For test failures, check database profile and logs in `backend/target/surefire-reports/`

---

## Shell Command Guidance
- Always provide commands that are PowerShell script compliant (Windows PowerShell v5.1).
	- Use `;` to join commands on a single line if needed.
	- Avoid bash-specific syntax.

For unclear or missing conventions, review `README.md` and key source files. Ask for feedback if any section is incomplete or ambiguous.
