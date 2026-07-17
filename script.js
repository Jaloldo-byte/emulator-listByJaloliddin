// Emulator database
const emulators = [
    {
        name: "Yuzu",
        system: "Nintendo Switch",
        rating: 4.8,
        description: "Leading Switch emulator with excellent compatibility",
        category: "Nintendo",
        github: "https://github.com/yuzu-emu/yuzu"
    },
    {
        name: "PCSX2",
        system: "PlayStation 2",
        rating: 4.7,
        description: "Most popular PS2 emulator",
        category: "Sony",
        github: "https://github.com/PCSX2/pcsx2"
    },
    {
        name: "Dolphin",
        system: "GameCube / Wii",
        rating: 4.9,
        description: "Best-in-class GameCube and Wii emulation",
        category: "Nintendo",
        github: "https://github.com/dolphin-emu/dolphin"
    },
    {
        name: "Ryujinx",
        system: "Nintendo Switch",
        rating: 4.6,
        description: "High-performance Switch emulator written in C#",
        category: "Nintendo",
        github: "https://github.com/Ryujinx/Ryujinx"
    },
    {
        name: "RPCS3",
        system: "PlayStation 3",
        rating: 4.5,
        description: "PS3 emulator with growing game compatibility",
        category: "Sony",
        github: "https://github.com/RPCS3/rpcs3"
    },
    {
        name: "Snes9x",
        system: "SNES",
        rating: 4.7,
        description: "Excellent SNES emulator",
        category: "Nintendo",
        github: "https://github.com/snes9xgit/snes9x"
    },
    {
        name: "mGBA",
        system: "Game Boy Advance",
        rating: 4.8,
        description: "Best GBA emulator for accuracy",
        category: "Nintendo",
        github: "https://github.com/mgba-emu/mgba"
    },
    {
        name: "Mupen64Plus",
        system: "Nintendo 64",
        rating: 4.6,
        description: "N64 emulator with excellent plugin system",
        category: "Nintendo",
        github: "https://github.com/mupen64plus/mupen64plus-core"
    },
    {
        name: "Flycast",
        system: "Dreamcast",
        rating: 4.7,
        description: "Modern Dreamcast emulator",
        category: "Sega",
        github: "https://github.com/flyinghead/flycast"
    },
    {
        name: "BlastEm",
        system: "Genesis / Mega Drive",
        rating: 4.5,
        description: "Accurate Genesis emulation",
        category: "Sega",
        github: "https://github.com/kconger/blastem"
    },
    {
        name: "PPSSPP",
        system: "PSP",
        rating: 4.8,
        description: "Best PSP emulator available",
        category: "Sony",
        github: "https://github.com/hrydgard/ppsspp"
    },
    {
        name: "DuckStation",
        system: "PlayStation 1",
        rating: 4.7,
        description: "Modern PS1 emulator with great accuracy",
        category: "Sony",
        github: "https://github.com/stenzek/duckstation"
    },
    {
        name: "Cemu",
        system: "Wii U",
        rating: 4.6,
        description: "Wii U emulator with improving compatibility",
        category: "Nintendo",
        github: "https://github.com/cemu-project/Cemu"
    },
    {
        name: "RetroArch",
        system: "Multi-System",
        rating: 4.5,
        description: "Frontend for 50+ emulators",
        category: "Multi",
        github: "https://github.com/libretro/RetroArch"
    },
    {
        name: "Mednafen",
        system: "Multi-System",
        rating: 4.4,
        description: "Portable emulator for many systems",
        category: "Multi",
        github: "https://github.com/mednafen/mednafen"
    },
    {
        name: "Stella",
        system: "Atari 2600",
        rating: 4.6,
        description: "Accurate Atari 2600 emulation",
        category: "Atari",
        github: "https://github.com/stella-emu/stella"
    }
];

const newsItems = [
    {
        title: "Yuzu 15.0 Released with Major Performance Boost",
        date: "July 15, 2026",
        description: "The latest version of Yuzu brings significant performance improvements and better game compatibility for Switch games."
    },
    {
        title: "PCSX2 Reaches 95% Game Compatibility Milestone",
        date: "July 14, 2026",
        description: "The popular PlayStation 2 emulator has achieved an impressive 95% compatibility rate with PS2 games."
    },
    {
        title: "Dolphin Emulator Gets New Graphics Backend",
        date: "July 13, 2026",
        description: "Dolphin team announces a new graphics backend option for improved performance on modern systems."
    },
    {
        title: "RetroArch Adds Support for 10 New Cores",
        date: "July 12, 2026",
        description: "The multi-system emulator frontend now supports 10 new emulation cores for retro systems."
    },
    {
        title: "RPCS3 PlayStation 3 Emulator Reaches New Milestone",
        date: "July 11, 2026",
        description: "More PS3 games are now playable with the RPCS3 emulator than ever before."
    },
    {
        title: "Nintendo Switch Emulation Advances Rapidly",
        date: "July 10, 2026",
        description: "Both Yuzu and Ryujinx continue to make progress in Switch game compatibility."
    }
];

document.addEventListener('DOMContentLoaded', function() {
    loadEmulators();
    loadNews();
    setupEventListeners();
});

function loadEmulators() {
    const grid = document.getElementById('emulatorsGrid');
    grid.innerHTML = '';
    
    emulators.forEach(emu => {
        const card = document.createElement('div');
        card.className = 'emulator-card';
        card.innerHTML = `
            <div class="emulator-header">
                <div class="emulator-name">${emu.name}</div>
                <div class="emulator-system">${emu.system}</div>
            </div>
            <div class="emulator-body">
                <div class="emulator-rating">
                    ${generateStars(emu.rating)}
                    <span>${emu.rating}</span>
                </div>
                <div class="emulator-desc">${emu.description}</div>
                <a href="${emu.github}" target="_blank" class="emulator-link">View on GitHub →</a>
            </div>
        `;
        grid.appendChild(card);
    });
}

function loadNews() {
    const feed = document.getElementById('newsFeed');
    feed.innerHTML = '';
    
    newsItems.forEach(news => {
        const card = document.createElement('div');
        card.className = 'news-card';
        card.innerHTML = `
            <div class="news-header">
                <div class="news-title">${news.title}</div>
                <div class="news-date">${news.date}</div>
            </div>
            <div class="news-body">
                <div class="news-desc">${news.description}</div>
            </div>
        `;
        feed.appendChild(card);
    });
}

function generateStars(rating) {
    let stars = '';
    const fullStars = Math.floor(rating);
    const hasHalf = rating % 1 !== 0;
    
    for (let i = 0; i < fullStars; i++) {
        stars += '<span class="star">★</span>';
    }
    
    if (hasHalf) {
        stars += '<span class="star">⯨</span>';
    }
    
    for (let i = fullStars + (hasHalf ? 1 : 0); i < 5; i++) {
        stars += '<span class="star" style="opacity: 0.3">★</span>';
    }
    
    return stars;
}

function setupEventListeners() {
    const searchInput = document.getElementById('searchInput');
    const categoryFilter = document.getElementById('categoryFilter');
    
    searchInput.addEventListener('input', filterEmulators);
    categoryFilter.addEventListener('change', filterEmulators);
    
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({ behavior: 'smooth' });
            }
        });
    });
}

function filterEmulators() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const category = document.getElementById('categoryFilter').value;
    const grid = document.getElementById('emulatorsGrid');
    grid.innerHTML = '';
    
    const filtered = emulators.filter(emu => {
        const matchesSearch = emu.name.toLowerCase().includes(searchInput) ||
                            emu.system.toLowerCase().includes(searchInput) ||
                            emu.description.toLowerCase().includes(searchInput);
        const matchesCategory = category === 'all' || emu.category === category;
        return matchesSearch && matchesCategory;
    });
    
    if (filtered.length === 0) {
        grid.innerHTML = '<p style="text-align: center; grid-column: 1/-1; color: #b0b0b0;">No emulators found. Try a different search!</p>';
        return;
    }
    
    filtered.forEach(emu => {
        const card = document.createElement('div');
        card.className = 'emulator-card';
        card.innerHTML = `
            <div class="emulator-header">
                <div class="emulator-name">${emu.name}</div>
                <div class="emulator-system">${emu.system}</div>
            </div>
            <div class="emulator-body">
                <div class="emulator-rating">
                    ${generateStars(emu.rating)}
                    <span>${emu.rating}</span>
                </div>
                <div class="emulator-desc">${emu.description}</div>
                <a href="${emu.github}" target="_blank" class="emulator-link">View on GitHub →</a>
            </div>
        `;
        grid.appendChild(card);
    });
}