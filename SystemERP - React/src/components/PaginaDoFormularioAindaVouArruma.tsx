import { useState } from 'react';

import FormCreateCorporative from './FormCreateCorporative';

function PaginaDoFormularioAindaVouArruma() {
  return (
    <div className='h-screen flex justify-items-end'>
      <div className='w-screen h-screen bg-[url(https://s3-alpha-sig.figma.com/img/584c/a172/e1f779e8b87c1cbe16d78a804b704456?Expires=1740960000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=lIEBfBI3D~v8q8NOTd4BelvrzkGa~H3-jLlA5HeqnMo4z~mSsz5-oAxcwzN-cXkOYrxP5jiXw-jla9pK1Ah7p6yr0x-9oRpg4I5XlbCnCHVNprmvq~S4AxTBwupeBapl~Vb-0VCgqWi-BINpgZvjp-GqeEihkDnKWJtCGB7CxAacj69erjjY-3fUIqH29E5OKC18wlgycykf4sNZygSgQ5OFolhgAeRvdlnrzdcHswgR2WdzOIEeQdf1CrpjsLBtGCYVULdA2uU7uVY6r6fj7Q3pHZMMkGCrCgwKJ8ZoXURwolnbASzloMYEAR9oFzejEqNe9YfJdMfroLyE3i6eKw__)] bg-cover bg-center'></div>
      <FormCreateCorporative/>
    </div>
  )
}

export default PaginaDoFormularioAindaVouArruma
