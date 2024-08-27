# Stage 1: Build the SvelteKit app
FROM node:18 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the SvelteKit app
RUN npm run build

# Stage 2: Serve the built app with a lightweight web server
FROM node:18-slim AS runner

# Set the working directory for the server
WORKDIR /app

# Copy the build output from the builder stage
COPY --from=builder /app/build ./build

# Install only production dependencies
COPY package*.json ./
RUN npm install --only=production

# Expose the port your SvelteKit app will run on
EXPOSE 3000

# Set the environment variable to indicate the app is running in production mode
ENV NODE_ENV production

# Start the server using the SvelteKit adapter for Node.js
CMD ["node", "build/index.js"]
