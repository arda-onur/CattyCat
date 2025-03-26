
"use client";

import { Swiper, SwiperSlide } from "swiper/react";
import { Autoplay, FreeMode  } from "swiper/modules";
import "swiper/css";
import { useState } from "react";

export default function LoginPage() {

    const [email, setEmail] = useState("");
    const [sifre, setSifre] = useState("");
    const [mesaj, setMesaj] = useState("");

    const resimler = [
        "erkekmavilogin.jpg",
        "kadınssiyahayakkabı.jpg",
        "siyaherkeklogin.png",
        "kıvırcıkkadın.jpg",
        "doubleçiftlogin.png",
    ];

    const handleLogin = async () => {
        try {
            const response = await fetch("http://localhost:8080/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    email: email,
                    password: sifre,
                }),
            });

            const result = await response.text();
            setMesaj(result);
        } catch (err) {
            console.error("Hata:", err);
            setMesaj("Sunucuya bağlanılamadı.");
        }
    };


    return (
        <div className="min-h-screen flex flex-col items-center justify-start relative bg-gradient-to-br from-white to-orange-400">
            <img
                src="kedilogo.png"
                alt="Leylek"
                className="w-20 h-20 object-contain absolute top-4 left-4 rounded-full shadow-md border-2 border-turquoise-400"
                style={{ borderColor: "orange" }}
            />

            <div className="w-100 max-w-2xl mt-8">
                <Swiper
                    spaceBetween={20}
                    slidesPerView={3}
                    loop={true}
                    modules={[Autoplay]}
                    autoplay={{
                        delay: 0,
                        disableOnInteraction: false }}
                    speed={10000}
                    freeMode={true}
                >
                    {resimler.map((src, i) => (
                        <SwiperSlide key={i}>
                            <img
                                src={`/${src}`}
                                alt={`slide-${i}`}
                                className="w-27 object-cover rounded-lg shadow-md"
                            />
                        </SwiperSlide>
                    ))}
                </Swiper>
            </div>


            <div className="w-full max-w-md bg-white rounded-xl shadow-md p-8 mt-8">
                <h2 className="text-2xl font-bold text-center text-orange-600">
                    Giriş Yap
                </h2>
                <form className="space-y-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700">
                            E-posta
                        </label>
                        <input
                            type="email"
                            className="mt-1 w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:accent-orange-600"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="yourmail@mail.com"
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">
                            Şifre
                        </label>
                        <input
                            type="password"
                            className="mt-1 w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:accent-orange-600"
                            value={sifre}
                            onChange={(e) => setSifre(e.target.value)}
                            placeholder="********"
                        />
                    </div>
                    <button type="button" onClick={handleLogin}
                          className="w-full accent-orange-600 text-white p-2 rounded-md hover:accent-orange-600 transition">
                        Giriş Yap
                    </button>
                </form>
                <div className="text-sm text-center text-gray-600 mt-4">
                    Hesabın yok mu?{" "}
                    <a href="/register" className="text-orange-600 hover:underline font-medium">
                        Kayıt ol
                    </a>
                </div>
            </div>
        </div>
    );
}
