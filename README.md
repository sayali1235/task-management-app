# task-management-app
A production-ready Java 15 solution to query REST APIs and track IP details. Optimized for automated test suites (HackerRank) with custom headers to bypass 403 Forbidden errors and native, memory-safe JSON string parsing without third-party libraries.
# REST API IP Tracker (HackerRank Solution)

A production-ready Java 15 solution for fetching and tracking IP addresses using external REST APIs. This project is specifically designed to handle enterprise constraints, safe string parsing without heavy dependencies, and proxy/security headers to pass complex automated testing environments like HackerRank.

## 🚀 Features
- **Zero Third-Party Dependencies:** Parses JSON smoothly using fast, direct memory index tracking (`indexOf` and `substring`) without risking framework or version mismatches.
- **Header Security Bypassing:** Incorporates a custom `User-Agent` spoofing property to prevent `403 Forbidden` errors from strict API firewalls.
- **Java 15+ Native Compliance:** Built completely around modern `java.net.URI` standards to eliminate structural compilation deprecation notices.
- **Edge-Case Validation:** Accurately isolates null entries, slow connection timeouts, and empty `"total": 0` pagination responses.

## 📂 Repository Structure
```text
├── src/
│   └── solution.java       # Standalone execution file containing the entry point
├── README.md               # Detailed project documentation and setup manual
└── .gitignore              # Files and directories to be ignored by Git
```

## 🛠️ Implementation Details
The codebase utilizes a greedy fallback network pipeline:
1. **Connection Lifecycle Management:** Disconnects explicitly within a `finally` block to prevent internal connection leaks.
2. **Memory-Safe Substring Extraction:** Prevents common markdown/regex parsing flaws inside competitive environments by calculating index limits dynamically via quotes.

## 💻 Tech Stack
- **Language:** Java 15 / Java 17
- **Network Layer:** Native `HttpURLConnection`
- **Build System:** Vanilla Java Compiler (javac)

## 🔧 How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com
   ```
2. Navigate into the source folder:
   ```bash
   cd YOUR_REPOSITORY_NAME/src
   ```
3. Compile the standalone source file:
   ```bash
   javac solution.java
   ```
4. Run the code and provide an IP input (e.g., `172.217.16.142`):
   ```bash
   java solution
   ```

## 📄 License
This project is open-source and available under the [MIT License](LICENSE).
