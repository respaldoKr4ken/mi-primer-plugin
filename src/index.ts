import { registerPlugin } from '@capacitor/core';

import type { MiPrimerPlugin } from './definitions';

const MiPrimer = registerPlugin<MiPrimerPlugin>('MiPrimer');

export * from './definitions';
export { MiPrimer };
