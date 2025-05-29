import { Heart } from "lucide-react";
import Rating from "react-rating";

export default function ProductsCard() {
    const ratingChanged = (newRating) => {
        console.log("Avaliação:", newRating);
    };

    const products = [
        {
            name: "Xbox One",
            price: "R$120.00",
            image:
                "data:image/jpeg;base64,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",
            rating: 4.5,
            reviews: 131,
        },
        {
            name: "PlayStation 5",
            price: "R$350.00",
            image:
                "data:image/jpeg;base64,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",
            rating: 5,
            reviews: 324,
        },
        {
            name: "Nintendo Switch",
            price: "R$250.00",
            image:
                "https://m.media-amazon.com/images/I/61-PblYntsL._AC_UF894,1000_QL80_.jpg",
            rating: 4,
            reviews: 210,
        },
    ];

    return (
        <div className="mt-10 px-4">
            <h1 className="text-xl font-bold mb-6">Produtos</h1>

            <div className="flex gap-12 overflow-x-auto mt-10">
                {products.map((product, index) => (
                    <div
                        key={index}
                        className="w-[260px] bg-white rounded-2xl shadow-[6px_6px_54px_rgba(0,0,0,0.05)] overflow-hidden relative flex-shrink-0"
                    >
                        {/* Imagem do produto */}
                        <div className="w-full h-52 bg-stone-50">
                            <img
                                src={product.image}
                                alt={product.name}
                                className="w-full h-full object-cover rounded-t-2xl"
                            />
                        </div>

                        <div className="p-4 space-y-2">
                            {/* Título e Preço */}
                            <div>
                                <h2 className="text-neutral-800 text-base font-bold">
                                    {product.name}
                                </h2>
                                <p className="text-blue-500 text-sm font-bold">
                                    {product.price}
                                </p>
                            </div>

                            {/* Estrelas e Coração */}
                            <div className="flex items-center justify-between">
                                <div className="flex items-center gap-1">
                                    <Rating
                                        initialRating={product.rating}
                                        fractions={2}
                                        onChange={ratingChanged}
                                        emptySymbol={
                                            <span className="text-gray-300 text-lg">☆</span>
                                        }
                                        fullSymbol={
                                            <span className="text-yellow-400 text-lg">★</span>
                                        }
                                    />
                                    <span className="text-xs text-black font-semibold opacity-40">
                                        ({product.reviews})
                                    </span>
                                </div>
                                <Heart className="text-red-500" size={18} />
                            </div>

                            {/* Botão */}
                            <button className="mt-3 w-full bg-indigo-100 text-xs font-bold text-neutral-800 py-2 rounded-xl opacity-70">
                                Editar Produto
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}
