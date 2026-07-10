import { WebPlugin } from '@capacitor/core';

import type { MiPrimerPlugin } from './definitions';

export class MiPrimerWeb extends WebPlugin implements MiPrimerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
