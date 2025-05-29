import { Search } from 'lucide-react';

export default function InputSearch() {
  return (
    <div className="relative mt-10 max-w-md mx-auto">
      <input
        type="text"
        placeholder="Buscar..."
        className="w-full pl-12 pr-4 py-1 border-2 border-gray-300 rounded-2xl focus:outline-none focus:ring-2 focus:ring-navIsActive"
      />
      <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-gray-400" size={20} />
    </div>
  );
}
