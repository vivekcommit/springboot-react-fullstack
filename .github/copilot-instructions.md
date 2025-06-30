# Copilot Instructions for This Project

- This is a full-stack project with a Spring Boot backend (Java, Maven) and a React frontend (create-react-app).
- Backend code is in the `backend/` folder. Frontend code is in the `frontend/` folder.
- When asked to add or modify API endpoints, edit or create Java classes in `backend/src/main/java/com/example/backend/`.
- When asked to update the UI or connect to backend APIs, edit React components in `frontend/src/`.
- Use the proxy setup in `frontend/package.json` for API calls from React to backend.
- Always check for CORS and port issues if the frontend cannot reach the backend.
- For documentation, update `README.md` in the project root.

# Example Tasks
- Add a new REST endpoint: create a new Java controller in the backend.
- Fetch data from backend: use `fetch('/api/your-endpoint')` in React.
- Update instructions: edit `README.md`.

# Best Practices
- Keep backend and frontend code modular and separated.
- Restart servers after changing configuration files.
- Use environment variables for secrets and configuration in production.
