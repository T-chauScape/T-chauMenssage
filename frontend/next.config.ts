import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  webpack: (config) => {
    config.watchOptions = {
      poll: 1000, // Verifica a cada 1000ms
      aggregateTimeout: 300,
    };
    return config;
  },
}

export default nextConfig;
