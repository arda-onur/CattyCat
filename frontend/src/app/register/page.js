"use client";

import { useState } from "react";

export default function RegisterPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [repassword, setrepassword] = useState("");
    const [message, setMessage] = useState("");



    const handleRegister = async () => {
        try {
            const response = await fetch("http://localhost:8080/auth/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    email: email,
                    password: password,
                    repassword: repassword
                }),
            });

            const result = await response.text();
            setMessage(result);
        } catch (err) {
            console.error("Error:", err);
            setMessage("Failed to connect to the server.");
        }
    };

    return (

        <div className="min-h-screen flex flex-col items-center justify-center relative bg-gradient-to-br from-white to-orange-400">
            <img
                src="kedilogo.png"
                alt="Kedi"
                className="w-20 h-20 object-contain absolute top-4 left-4 rounded-full shadow-md border-2 border-turquoise-400"
                style={{ borderColor: "orange"}}
            />
            <div className="w-full max-w-md bg-white p-8 rounded shadow-md">
                <h2 className="text-2xl font-bold text-center mb-6 text-orange-600">Signup</h2>

                <div className="space-y-4">

                    <div>
                        <label className="block text-sm font-medium text-gray-700">
                            E-mail
                        </label>
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="mt-1 w-full border border-gray-300 rounded p-2"
                            placeholder="yourmail@mail.com"
                            required
                        />
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700">
                            Password
                        </label>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className="mt-1 w-full border border-gray-300 rounded p-2"
                            placeholder="********"
                            required
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">
                          Re-Password
                        </label>
                        <input
                            type="password"
                            value={repassword}
                            onChange={(e) => setrepassword(e.target.value)}
                            className="mt-1 w-full border border-gray-300 rounded p-2"
                            placeholder="********"
                            required
                        />
                    </div>
                    <button
                        type="button"
                        onClick={handleRegister}
                        className="w-full bg-orange-600 text-white p-2 rounded hover:bg-orange-700 transition"
                    >
                        Sign up
                    </button>

                    {message && (
                        <p className="text-center text-sm text-orange-600 mt-4">{message}</p>
                    )}

                    <div className="text-sm text-center mt-4">
                        Already have an account?{" "}
                        <a href="/login" className="text-orange-600 hover:underline">
                            Log in
                        </a>
                    </div>
                </div>
            </div>
        </div>
    );
}