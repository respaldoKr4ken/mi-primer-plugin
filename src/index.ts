import { registerPlugin } from '@capacitor/core';

import type { MiPrimerPlugin } from './definitions';

const MiPrimer = registerPlugin<MiPrimerPlugin>('MiPrimer', {
  web: () => import('./web').then((m) => new m.MiPrimerWeb()),
});

export * from './definitions';
export { MiPrimer };
