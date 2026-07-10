export interface MiPrimerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
